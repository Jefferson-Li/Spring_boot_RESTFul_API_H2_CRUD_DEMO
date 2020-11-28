package com.jefferson.restful.h2.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jefferson.restful.h2.dto.RestH2Request;
import com.jefferson.restful.h2.dto.RestH2Response;
import com.jefferson.restful.h2.entity.RestH2Entity;
import com.jefferson.restful.h2.exception.RestH2Exception;
import com.jefferson.restful.h2.repository.RestH2Repository;
import com.jefferson.restful.h2.service.RestH2Service;

@Service
public class RestH2ServiceImpl implements RestH2Service {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RestH2Repository restH2Repository;

	@Override
	public RestH2Response create(RestH2Request request) {

		RestH2Response restH2Response = new RestH2Response();
		try {
			LocalDateTime now = LocalDateTime.now();
			RestH2Entity restH2Entity = restH2Repository
					.save(new RestH2Entity(request.getShopid(), request.getShopName(), request.getShopNo(), now, now));

			List<RestH2Entity> restH2EntityList = new ArrayList<RestH2Entity>();

			restH2EntityList.add(restH2Entity);
			restH2Response.setData(restH2EntityList);
			restH2Response.setResponseCode("0000");
			restH2Response.setResponseMessage("新增成功");
			return restH2Response;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public RestH2Response queryById(Long shopId) {
		RestH2Response restH2Response = new RestH2Response();

		try {

			Optional<RestH2Entity> optional = restH2Repository.findById(shopId);
			if (optional.isPresent()) {

				restH2Response.setData(toList(optional));
				restH2Response.setResponseCode("0001");
				restH2Response.setResponseMessage("查詢ID成功");
				return restH2Response;

			} else {
				restH2Response.setResponseCode("9999");
				restH2Response.setResponseMessage("查詢ID失敗");
				return restH2Response;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	@Override
	public RestH2Response queryAll() throws Exception {
		RestH2Response restH2Response = new RestH2Response();

		try {
			List<RestH2Entity> restH2EntityList = restH2Repository.findAll();

			// 確認 table 有無資料
			if (restH2EntityList.isEmpty()) {
				logger.debug("table 無資料:" + restH2EntityList);
				throw new RestH2Exception();
			}

			restH2Response.setData(restH2EntityList);
			restH2Response.setResponseCode("0002");
			restH2Response.setResponseMessage("查詢全部成功");

			return restH2Response;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public RestH2Response update(RestH2Request request) throws Exception {

		RestH2Response restH2Response = new RestH2Response();

		try {

			long id = request.getShopid();
			String shopName = request.getShopName();
			Integer shopNo = request.getShopNo();
			LocalDateTime now = LocalDateTime.now();

			// Step1 先查詢table值
			Optional<RestH2Entity> listMap = restH2Repository.findById(id);

			List<RestH2Entity> restH2EntityList = toList(listMap);

			// 確認 table 有無資料
			if (restH2EntityList.isEmpty()) {
				logger.debug("table 無資料:" + restH2EntityList);
				throw new RestH2Exception();
			}

			// 確認 table 有無資料
			if (listMap.isPresent()) {

				for (RestH2Entity restH2Entity : restH2EntityList) {
					restH2Entity.setShopId(id);
					restH2Entity.setShopName(shopName);
					restH2Entity.setShopNo(shopNo);
					restH2Entity.setShopCreateTime(now);
					restH2Entity.setShopUpdateTime(now);
					restH2Repository.save(restH2Entity);
				}

				restH2Response.setData(restH2EntityList);
				restH2Response.setResponseCode("0003");
				restH2Response.setResponseMessage("更新成功");

			} else {
				restH2Response.setResponseCode("9999");
				restH2Response.setResponseMessage("更新失敗");
				return restH2Response;
			}

		} catch (

		Exception e) {
			logger.error(e.getMessage(), e);
			// 有logger就不需e.printStackTrace()
			throw e;
		}

		return restH2Response;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public RestH2Response delete(Long shopId) throws Exception {

		RestH2Response restH2Response = new RestH2Response();

		try {

			// Step1 先查詢
			Optional<RestH2Entity> optional = restH2Repository.findById(shopId);

			List<RestH2Entity> restH2EntityList = toList(optional);

			// 確認 table 有無資料
			if (restH2EntityList.isEmpty()) {
				logger.debug("table 無資料:" + restH2EntityList);
				throw new RestH2Exception();
			}

			if (optional.isPresent()) {

				// Step2 取值，確認上行id是否跟table id值一樣
				boolean checkColumn = checkColumnValue(restH2EntityList, shopId);

				if (checkColumn == true) {
					// Step3 repository.delete
					restH2Repository.deleteById(shopId);
				}

				restH2Response.setData(restH2EntityList);
				restH2Response.setResponseCode("0004");
				restH2Response.setResponseMessage("刪除成功");
			} else {
				restH2Response.setResponseCode("9999");
				restH2Response.setResponseMessage("刪除失敗");
				return restH2Response;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

		return restH2Response;
	}

	/**
	 * Optional轉List
	 * 
	 * @param <T>
	 * @param option
	 * @return
	 */
	public static <T> List<T> toList(Optional<T> optional) {
		return optional.map(Collections::singletonList).orElse(Collections.emptyList());
	}

	/**
	 * 檢查db撈出值是否相同
	 * 
	 * @param restH2EntityList
	 * @param id
	 * @return
	 */
	public Boolean checkColumnValue(List<RestH2Entity> restH2EntityList, Long id) {

		Boolean isValue = false;

		for (RestH2Entity restH2Entity : restH2EntityList) {
			if (restH2Entity.getShopId().equals(id)) {
				isValue = true;
			}
		}

		return isValue;
	}

}

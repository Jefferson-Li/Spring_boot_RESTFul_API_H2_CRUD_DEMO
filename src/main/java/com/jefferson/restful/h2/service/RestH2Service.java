package com.jefferson.restful.h2.service;

import com.jefferson.restful.h2.dto.RestH2Request;
import com.jefferson.restful.h2.dto.RestH2Response;

public interface RestH2Service {

	/**
	 * create
	 * 
	 * @param request
	 * @return
	 */
	public RestH2Response create(RestH2Request request);

	/**
	 * queryById
	 * 
	 * @param request
	 * @return
	 */
	public RestH2Response queryById(Long shopId);

	/**
	 * queryAll
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public RestH2Response queryAll() throws Exception;

	/**
	 * update
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public RestH2Response update(RestH2Request request) throws Exception;

	/**
	 * delete
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public RestH2Response delete(Long shopId) throws Exception;

}

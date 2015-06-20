package com.github.scompo.scompotodo.api.v1;

public interface V1ApiEndpoints {

	public static final String API_PREFIX = "/api";

	public static final String V1_PREFIX = "/v1";

	public static final String V1_API_PREFIX = API_PREFIX + V1_PREFIX;

	public interface HelloEndpoints {

		public static final String HELLO = V1_API_PREFIX + "/hello";
	}
}

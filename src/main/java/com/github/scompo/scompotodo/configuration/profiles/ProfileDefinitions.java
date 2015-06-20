package com.github.scompo.scompotodo.configuration.profiles;

public enum ProfileDefinitions {

	/**
	 * Production profile.
	 */
	PRODUCTION(ProfileConstants.PRODUCTION),

	/**
	 * Development profile.
	 */
	DEVELOPMENT(ProfileConstants.DEVELOPMENT);

	private final String profileName;

	private ProfileDefinitions(String profileName) {

		this.profileName = profileName;
	}

	@Override
	public String toString() {

		return profileName;
	}
}

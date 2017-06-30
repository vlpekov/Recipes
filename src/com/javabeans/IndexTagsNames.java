package com.javabeans;

import java.io.Serializable;

import com.vso.interfaces.IndexTags;

public class IndexTagsNames implements Serializable, IndexTags {
	public String getIframeGetParameter() {
		return iframeGetParameter;
	}

	public String getUsernameInputName() {
		return usernameInputName;
	}

	public String getPasswordInputName() {
		return passwordInputName;
	}
}

package com.bignlp.commons;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

public class PathMatcherCache {
	private static final String GLOB = "glob:";

	public PathMatcherCache() {
		// TODO Auto-generated constructor stub
	}

	public PathMatcher getPathMatcher(String p) {
		return FileSystems.getDefault().getPathMatcher(GLOB + p);
	}
}

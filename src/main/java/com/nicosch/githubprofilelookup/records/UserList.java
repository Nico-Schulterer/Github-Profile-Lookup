package com.nicosch.githubprofilelookup.records;

public record UserList(int total_count, boolean incomplete_results, Object items) { }
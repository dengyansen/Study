package designPatterns;

public interface Filter {
	void doFilter(User user,FilterChain chain);
}

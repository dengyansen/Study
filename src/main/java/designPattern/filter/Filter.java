package designPattern.filter;

public interface Filter {
	void doFilter(User user,FilterChain chain);
}

package designPattern.filter;

public class TestFilter {
	public static void main(String[] args) {
		User user = new User("jasen","脏话");
		FilterChain chain = new FilterChain();
		chain.addFilter(new LogFilter()).addFilter(new AuthFilter());
		chain.doFilter(user,chain);
	}
	static class LogFilter implements  Filter{
		public void doFilter(User user, FilterChain chain) {
			if(user != null){
				System.out.println(" LogFilter user  ="+user);
			}
			chain.doFilter(user,chain);
		}
	}
	static class AuthFilter implements  Filter{
		public void doFilter(User user, FilterChain chain) {
			if(user.getName() != null){
				System.out.println(" AuthFilter user login name="+user.getName());
			}
			chain.doFilter(user,chain);
		}
	}
}

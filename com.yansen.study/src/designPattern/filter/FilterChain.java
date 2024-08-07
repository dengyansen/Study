package designPattern.filter;

import java.util.ArrayList;
import java.util.List;
//https://www.jianshu.com/p/5afdbb0c9d81
//tomcat中的过滤链实现
public class FilterChain implements Filter {
	//用List集合来存储过滤规则
	List<Filter> filters = new ArrayList<Filter>();
	//用于标记规则的引用顺序
	int index =0 ;
	//往规则链条中添加规则
	public FilterChain addFilter(Filter f) {
		filters.add(f);
		//代码的设计技巧:Chain链添加过滤规则结束后返回添加后的Chain，方便我们下面doFilter函数的操作
		return this;
	}

	public void doFilter(User user, FilterChain chain){
		if(index==filters.size()){//过滤链尾终止返回
			return;
		}
		Filter f = filters.get(index);
		index ++;
		//根据索引值获取对应的规律规则对字符串进行处理
		f.doFilter(user, chain);
	}
}

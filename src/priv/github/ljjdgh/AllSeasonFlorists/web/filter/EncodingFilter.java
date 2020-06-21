package priv.github.ljjdgh.AllSeasonFlorists.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse)response;
		resp.setContentType("text/html;charset=utf-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletRequest rRequest = new RRequest(req);
		
		chain.doFilter(rRequest, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

class RRequest extends HttpServletRequestWrapper{
	//引入增强对象
	private HttpServletRequest request;
	boolean hasEncode = false;
	
	public RRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name) {
		Map<String,String[]> parameterMap = request.getParameterMap();
		String[] values = parameterMap.get(name);
		if(values == null) {
			return null;
		}
		return values[0];
	}
	
	@Override
	public Map<String, String[]> getParameterMap() {
		//获取请求方式
		String method = request.getMethod();
		if(method.equalsIgnoreCase("post")) {
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else
			if(method.equalsIgnoreCase("get")) {
				Map<String,String[]> parameterMap = request.getParameterMap();
				if(!hasEncode) {
					for(String parameterName:parameterMap.keySet()) {
						String[] values = parameterMap.get(parameterName);
						if(values != null) {
							for(int i = 0;i < values.length;i++) {
								String value = values[i];
								try {
									value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
								} catch(UnsupportedEncodingException e) {
									e.printStackTrace();
								}
							}
						}
					}
					hasEncode = true;
				}
				return parameterMap;
			}
		return super.getParameterMap();
	}
	
	@Override
	public String[] getParameterValues(String name) {
		Map<String,String[]> parameterMap = request.getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}
	
}

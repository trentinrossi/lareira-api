package br.com.lareira.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoPadraoCriadoEvent extends ApplicationEvent {

	private HttpServletResponse response;
	private Long codigo;

	private static final long serialVersionUID = 1L;

	public RecursoPadraoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}
}

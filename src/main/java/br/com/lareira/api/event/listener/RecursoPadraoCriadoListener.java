package br.com.lareira.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.lareira.api.event.RecursoPadraoCriadoEvent;

@Component
public class RecursoPadraoCriadoListener implements ApplicationListener<RecursoPadraoCriadoEvent> {
	
	@Override
	public void onApplicationEvent(RecursoPadraoCriadoEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Long codigo = recursoCriadoEvent.getCodigo();

		adicionarHeaderLocation(response, codigo);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
}

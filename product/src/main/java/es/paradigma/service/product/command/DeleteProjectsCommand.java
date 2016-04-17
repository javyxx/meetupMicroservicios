package es.paradigma.service.product.command;
import com.paradigma.arquitecture.StaticApplicationContextAccess;
import com.paradigma.arquitecture.command.EventCommand;

import es.paradigma.service.product.domain.ProductRepository;

public class DeleteProjectsCommand extends EventCommand{

	public DeleteProjectsCommand() {
		super();
	}

	@Override
	protected void execute() {
		String userId = (String) this.event.getData().get("userId");
		ProductRepository productRepository =StaticApplicationContextAccess.
				getApplicationContext().getBean(ProductRepository.class);
		
		productRepository.deleteByUserId(userId);

	}

}

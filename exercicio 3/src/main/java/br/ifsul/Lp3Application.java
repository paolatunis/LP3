package br.ifsul;

import java.sql.Date;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lp3Application extends UIDespesa {
	
	@Autowired
	private DespesaRepository despesaRepository;	

	public static void main(String[] args) throws Throwable {
		
		SpringApplication.run(Lp3Application.class, args);
		
		
	}

	@Override
	protected void onNovaDespesa() {
		String des = txtDescricaoDespesa.getText();
		String val = txtValorDespesa.getText();
		String dat = txtDataDespesa.getText();
		
		Despesa d = new Despesa();
		d.setDescricao(des);
		d.setData(Date.valueOf(dat));
		d.setValor(Float.parseFloat(val));
		
		//persiste no banco de dados
		d = despesaRepository.save(d);
		
		modelDespesas.addElement(d);
		
	}

	@Override
	protected void onRemoverDespesa(Despesa selecionado) {
		despesaRepository.delete(selecionado); // remove do banco
		modelDespesas.removeElement(selecionado); //remove da lista
	
	}
	

}

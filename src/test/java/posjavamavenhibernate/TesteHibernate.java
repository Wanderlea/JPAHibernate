package posjavamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setNome("Maria");
		pessoa.setSobrenome("Lima da Silva");
		pessoa.setEmail("maria.lima@teste.teste");
		pessoa.setIdade(33);
		pessoa.setLogin("teste");
		pessoa.setSenha("123");
		
		daoGeneric.salvar(pessoa);
	}
	
	@Test
	public void testeUpdate(){
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
		pessoa.setIdade(99);
		pessoa.setNome("Nome Atualizado");
		
		daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
	}
	
	@Test
	public void testeBuscar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
	}
	
	@Test
	public void testeBuscarID(){
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
		
		System.out.println(pessoa);
	}
}

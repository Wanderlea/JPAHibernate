package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setNome("Marta");
		pessoa.setSobrenome("Lima da Silva");
		pessoa.setEmail("maria.lima@teste.teste");
		pessoa.setIdade(33);
		pessoa.setLogin("teste");
		pessoa.setSenha("123");

		daoGeneric.salvar(pessoa);
	}

	@Test
	public void testeUpdate() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
		pessoa.setIdade(99);
		pessoa.setNome("Nome Atualizado");

		daoGeneric.updateMerge(pessoa);

		System.out.println(pessoa);
	}

	@Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);

		pessoa = daoGeneric.pesquisar(pessoa);

		System.out.println(pessoa);
	}

	@Test
	public void testeBuscarID() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);

		System.out.println(pessoa);
	}

	@Test
	public void testeDelete() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);

		daoGeneric.deletaPorId(pessoa);

	}

	@Test
	public void testeConsultar() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);

		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
		}

	}
	
	@Test
	public void testeQueryList(){
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa where nome = 'Marta'").getResultList();
		
		for(UsuarioPessoa usuarioPessoa : list){
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQueryListMaxResult(){
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa order by id ").setMaxResults(3).getResultList();
		
		for(UsuarioPessoa usuarioPessoa : list){
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQueryListParameter(){
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa where nome = :nome or sobrenome = :sobrenome" )
				.setParameter("nome", "Marta")
				.setParameter("sobrenome", "Lima da Silva")
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
		
	}
}

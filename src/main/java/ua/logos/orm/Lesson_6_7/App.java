package ua.logos.orm.Lesson_6_7;

import java.math.BigDecimal;
import java.util.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entity.Comment;
import entity.Post;
import entity.Product;
import entity.Tag;
import entity.enums.Status;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		 //addTags(em);
		 //addPost(em);
		//addComment(em);

		// List<Comment> comments = em.createQuery("SELECT c FROM Comment c",
		// Comment.class).getResultList(); //all from comment`s table
		// comments.forEach(c -> System.out.println(c));
		//
		// Comment commentById = em.createQuery("SELECT c FROM Comment c WHERE c.id =
		// :id", Comment.class).setParameter("id", 40).getSingleResult(); //return
		// comment with id = 40;
		// System.out.println(commentById);
		//
		// List<Post> posts = em.createQuery("SELECT p FROM Post p WHERE p.id >
		// :post_id", Post.class).setParameter("post_id", 50).getResultList();
		// posts.forEach(p -> System.out.println(p));
		//
		// List<Post> posts1 = em.createQuery("SELECT p FROM Post p WHERE p.id IN
		// (:ids)", Post.class).setParameter("ids",
		// Arrays.asList(2,56,3,76,99,34)).getResultList();
		// posts1.forEach(p -> System.out.println(p));
		//
		// List<Post> posts2 = em.createQuery("SELECT p FROM Post p WHERE p.title LIKE
		// :post_title", Post.class).setParameter("post_title", "%8").getResultList();
		// //8 on the end
		// posts2.forEach(p -> System.out.println(p));
		//
		// List<Post> posts3 = em.createQuery("SELECT p FROM Post p WHERE p.title LIKE
		// :post_title", Post.class).setParameter("post_title", "%8_").getResultList();
		// //8 on the end
		// posts3.forEach(p -> System.out.println(p));
		//
		// List<Post> posts4 = em.createQuery("SELECT p FROM Post p WHERE p.id BETWEEN
		// :first AND :last", Post.class).setParameter("first",76).setParameter("last",
		// 82).getResultList();
		// posts4.forEach(p -> System.out.println(p));

		// Agreg functoin

		// Long count = em.createQuery("SELECT count(c.id) FROM Comment c",
		// Long.class).getSingleResult();
		// System.out.println("Count: " + count);
		//
		// Long sum = em.createQuery("SELECT sum(c.id) FROM Comment c",
		// Long.class).getSingleResult();
		// System.out.println("Sum: " + sum);
		//
		// Double average = em.createQuery("SELECT avg(c.id) FROM Comment c",
		// Double.class).getSingleResult();
		// System.out.println("Avarege: " + average);
		//
		// Integer max = em.createQuery("SELECT max(c.id) FROM Comment c",
		// Integer.class).getSingleResult();
		// System.out.println("MAX: " + max);
		//
		// Integer min = em.createQuery("SELECT min(c.id) FROM Comment c",
		// Integer.class).getSingleResult();
		// System.out.println("MIN: " + min);
		
//		Product product = em.createQuery("SELECT p FROM Product p WHERE p.id = ?1", Product.class).setParameter(1, 5).getSingleResult();
//		System.out.println(product);
//
//		Post post = em.createQuery("SELECT p FROM Post p WHERE p.id = ?1", Post.class).setParameter(1, 5).getSingleResult();
//		System.out.println(post);
		
//		Post post = em.createQuery("SELECT p FROM Post p RIGHT JOIN FETCH p.product pp WHERE p.id = :id", Post.class).setParameter("id", 9).getSingleResult();
//		System.out.println(post);
//		System.out.println(post.getProduct());
		
		
		//Criteria
		
		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Post> query = cb.createQuery(Post.class);
//		Root<Post> root = query.from(Post.class);   // FROM Post p
//		query.select(root); //SELECT p FROM Post p
		
//		Expression<Integer> idExpression = root.get("id");  //id
//		Predicate idPredicate = cb.greaterThan(idExpression, 85); //id>85
//		query.where(idPredicate); // SELECT p FROM Post p WHERE id>85
		
//		Expression<Integer> idExpression = root.get("id");  //id
//		Predicate idPredicateMin = cb.greaterThanOrEqualTo(idExpression, 40); //id>40
//		Predicate idPredicateMax = cb.lessThan(idExpression, 60); //id<60
//		Predicate allId = cb.and(idPredicateMin,idPredicateMax);
//		query.where(allId); // SELECT p FROM Post p WHERE id>=40 && id<60
		
//		Join<Post, Product> postJoinProduct = root.join("product");
//		Expression<BigDecimal> priceExpression = postJoinProduct.get("price");
//		Predicate pricePredicate = cb.between(priceExpression, new BigDecimal(30.00), new BigDecimal(50.00));
//		query.where(pricePredicate);
		
//		Expression<String> productNameExpression = postJoinProduct.get("name");
//		Predicate productNamePredicate = cb.like(productNameExpression, "%4");
//		query.where(productNamePredicate);
		
	
//		Expression<String> productNameExpression = postJoinProduct.get("name");
//		Expression<Integer> idExpression = root.get("id");
//		Predicate idPredicateMin = cb.greaterThanOrEqualTo(idExpression, 10);
//		Predicate productNamePredicate = cb.like(productNameExpression, "%4");
//		Predicate c = cb.and(idPredicateMin,productNamePredicate);
//		query.where(c);
//		List<Post> posts = em.createQuery(query).getResultList();
//		posts.forEach(p -> System.out.println(p));
		
//		1. всі з Coment
//		2. всі з Product де id>80
//		3. всі з Post через LIKE де title закінчується на 8 
//		4. з Product 10-25
//		5. Product 2,45,34,12,65
		
//		List<Comment> comments = em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList(); 																				
//		comments.forEach(c -> System.out.println(c));
//
//		List<Product> pr = em.createQuery("SELECT p FROM Product p WHERE p.id >:id", Product.class)
//				.setParameter("id", 80).getResultList();
//		pr.forEach(p -> System.out.println(p));
//
//		List<Post> posts2 = em.createQuery("SELECT p FROM Post p WHERE p.title LIKE :post_title", Post.class)
//				.setParameter("post_title", "%8").getResultList();
//
//		posts2.forEach(p -> System.out.println(p));
//
//		List<Product> product = em
//				.createQuery("SELECT p FROM Product p WHERE p.id BETWEEN " + ":first AND :last", Product.class)
//				.setParameter("first", 10).setParameter("last", 25).getResultList();
//		product.forEach(p -> System.out.println(p));
//
//		List<Product> pr2 = em.createQuery("SELECT p FROM Product p WHERE p.id IN (:ids)", Product.class)
//				.setParameter("ids", Arrays.asList(2, 45, 34, 12, 65)).getResultList();
//		pr2.forEach(p -> System.out.println(p));
		
//		1. всі з Coment
//		2. всі з Product де id>80
//		3. всі з Post через LIKE де title закінчується на 8 
//		4. з Product 10-25
//		5. Product 2,45,34,12,65
//		Через Criteria
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Comment> query = cb.createQuery(Comment.class);
		Root<Comment> root = query.from(Comment.class);   
		query.select(root); 
		List<Comment> posts = em.createQuery(query).getResultList();
		posts.forEach(p -> System.out.println(p));
		
		CriteriaQuery<Product> query1 = cb.createQuery(Product.class);
		Root<Product> root1 = query1.from(Product.class);
		Expression<Integer> idExpression = root1.get("id"); 
		Predicate idPredicate = cb.greaterThan(idExpression, 80); 
		query1.where(idPredicate); 
		List<Product> pr = em.createQuery(query1).getResultList();
		pr.forEach(p -> System.out.println(p));
		
		
		
		
		
		
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	private static void addTags(EntityManager em) {
		List<String> tags = new ArrayList<String>();
		tags.add("Java");
		tags.add("SQL");
		tags.add("ORM");
		tags.add("JPL");
		tags.add("MySQL");
		tags.add("STS");
		tags.add("Eclipse");

		for (int i = 0; i < tags.size(); i++) {
			Tag tag = new Tag();
			tag.setName(tags.get(i));
			em.persist(tag);
		}
	}

	private static void addPost(EntityManager em) {

		for (int i = 1; i <= 100; i++) {
			Post post = new Post();
			post.setTitle("Post title" + i);
			post.setContent("Long post content#" + i);
			if (i % 2 == 0)
				post.setStatus(Status.DRAFT);
			if (i % 2 == 1)
				post.setStatus(Status.PUBLISH);

			Product product = new Product();
			product.setName("Product name#" + i);
			product.setDescription("Product description#" + i);
			product.setPrice(new BigDecimal(i + 10 + ".00"));
			product.setInStock(15 + i);

			post.setProduct(product);

			em.persist(post);

			List<Tag> tags = em.createQuery("SELECT t FROM Tag t", Tag.class).getResultList();
			post.setTags(tags);
		}
	}

	private static void addComment(EntityManager em) {

		for (int i = 1; i <= 100; i++) {
			Post post = em.createQuery("SELECT p FROM Post p WHERE p.id = :id", Post.class).setParameter("id", i)
					.getSingleResult();

			Comment comment = new Comment();
			comment.setAuthor("Author #" + i);
			comment.setComment("The best comment#" + i);
			comment.setPost(post);
			em.persist(comment);

		}
	}

}

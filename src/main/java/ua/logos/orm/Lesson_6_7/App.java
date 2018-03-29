package ua.logos.orm.Lesson_6_7;

import java.util.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Comment;
import entity.Post;
import entity.Tag;
import entity.enums.Status;


public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
       EntityManager em = factory.createEntityManager();
       em.getTransaction().begin();
       
//       addTags(em);
//       addPost(em);
//       addComment(em);
       
       List<Comment> comments = em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();    //all from comment`s table
       
       comments.forEach(c -> System.out.println(c));
       
       Comment commentById =  em.createQuery("SELECT c FROM Comment c WHERE c.id = :id", Comment.class).setParameter("id", 40).getSingleResult();   //return comment with id = 40;
       System.out.println(commentById);
       
       List<Post> posts = em.createQuery("SELECT p FROM Post p WHERE p.id > :post_id", Post.class).setParameter("post_id", 50).getResultList();
       posts.forEach(p -> System.out.println(p));
       
       List<Post> posts1 = em.createQuery("SELECT p FROM Post p WHERE p.id IN (:ids)", Post.class).setParameter("ids", Arrays.asList(2,56,3,76,99,34)).getResultList();
       posts1.forEach(p -> System.out.println(p));
       
       List<Post> posts2 = em.createQuery("SELECT p FROM Post p WHERE p.title LIKE :post_title", Post.class).setParameter("post_title", "%8").getResultList();   //8 on the end
       posts2.forEach(p -> System.out.println(p));
       
       List<Post> posts3 = em.createQuery("SELECT p FROM Post p WHERE p.title LIKE :post_title", Post.class).setParameter("post_title", "%8_").getResultList();   //8 on the end
       posts3.forEach(p -> System.out.println(p));
       
       List<Post> posts4 = em.createQuery("SELECT p FROM Post p WHERE p.id BETWEEN :first AND :last", Post.class).setParameter("first",76).setParameter("last", 82).getResultList();
       posts4.forEach(p -> System.out.println(p));
       
       //Agreg functoin
       
       Long count = em.createQuery("SELECT count(c.id) FROM Comment c", Long.class).getSingleResult();
       System.out.println("Count: " + count);
       
       Long sum = em.createQuery("SELECT sum(c.id) FROM Comment c", Long.class).getSingleResult();
       System.out.println("Sum: " + sum);
       
       Double average = em.createQuery("SELECT avg(c.id) FROM Comment c", Double.class).getSingleResult();
       System.out.println("Avarege: " + average);
       
       Integer max = em.createQuery("SELECT max(c.id) FROM Comment c", Integer.class).getSingleResult();
       System.out.println("MAX: " + max);
       
       Integer min = em.createQuery("SELECT min(c.id) FROM Comment c", Integer.class).getSingleResult();
       System.out.println("MIN: " + min);
       
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
			if(i%2==0) post.setStatus(Status.DRAFT);
			if(i%2==1) post.setStatus(Status.PUBLISH);
			em.persist(post);
			
			List<Tag> tags = em.createQuery("SELECT t FROM Tag t", Tag.class).getResultList();
			post.setTags(tags);
		}
    }
    
    private static void addComment(EntityManager em) {
    	
    	for (int i = 1; i <= 100; i++) {
			Post post = em.createQuery("SELECT p FROM Post p WHERE p.id = :id", Post.class).setParameter("id", i).getSingleResult();
			
			Comment comment = new Comment();
			comment.setAuthor("Author #"+ i);
			comment.setComment("The best comment#" + i);
			comment.setPost(post);
			em.persist(comment);
			
			
			
		}
    }


}

package com.sismics.docs.core.dao.jpa;

import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.dao.DocumentDao;
import com.sismics.docs.core.dao.UserDao;
import com.sismics.docs.core.model.jpa.Document;
import com.sismics.docs.core.model.jpa.User;
import com.sismics.docs.core.util.TransactionUtil;
import com.sismics.docs.core.util.authentication.InternalAuthenticationHandler;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the persistance layer.
 *
 * @author jtremeaux
 */
public class TestJpa extends BaseTransactionalTest {
//    @Test
//    public void testJpa() throws Exception {
//        // Create a user
//        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUsername("username");
//        user.setPassword("12345678");
//        user.setEmail("toto@docs.com");
//        user.setRoleId("admin");
//        user.setStorageQuota(10L);
//        String userId = userDao.create(user, "me");
//
//        TransactionUtil.commit();
//
//        // Search a user by his ID
//        user = userDao.getById(userId);
//        Assert.assertNotNull(user);
//        Assert.assertEquals("toto@docs.com", user.getEmail());
//
//        // Authenticate using the database
//        Assert.assertNotNull(new InternalAuthenticationHandler().authenticate("username", "12345678"));
//
//        DocumentDao documentDao = new DocumentDao();
//        Document document = getDocument();
//
//        // Create the document using DocumentDao
//        String documentId = documentDao.create(document, "test_user_id");
//
//        TransactionUtil.commit();
//
//        // Retrieve the created document
//        Document retrievedDocument = documentDao.getById(documentId);
//        Assert.assertNotNull(retrievedDocument);
//        Assert.assertEquals("Test Document", retrievedDocument.getTitle());
//        Assert.assertEquals("This is a test document.", retrievedDocument.getDescription());
//
//        // Update the document
//        retrievedDocument.setTitle("Updated Test Document");
//        documentDao.update(retrievedDocument, "test_user_id");
//
//        TransactionUtil.commit();
//
//        // Retrieve the updated document
//        Document updatedDocument = documentDao.getById(documentId);
//        Assert.assertNotNull(updatedDocument);
//        Assert.assertEquals("Updated Test Document", updatedDocument.getTitle());
//
//        // Delete the document
//        documentDao.delete(documentId, "test_user_id");
//
//        TransactionUtil.commit();
//
//        // Try to retrieve the deleted document
//        Document deletedDocument = documentDao.getById(documentId);
//        Assert.assertNull(deletedDocument);
//    }
    @Test
    public void testJpa() throws Exception {
        // Create a user
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("username");
        user.setPassword("12345678");
        user.setEmail("toto@docs.com");
        user.setRoleId("admin");
        user.setStorageQuota(10L);
        String userId = userDao.create(user, "me");

        TransactionUtil.commit();

        // Search a user by his ID
        user = userDao.getById(userId);
        Assert.assertNotNull(user);
        Assert.assertEquals("toto@docs.com", user.getEmail());

        // Authenticate using the database
        Assert.assertNotNull(new InternalAuthenticationHandler().authenticate("username", "12345678"));

        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setPassword("newpassword");
        userDao.updatePassword(updatedUser, "me");

        TransactionUtil.commit();

        // Authenticate using the new password
        Assert.assertNotNull(new InternalAuthenticationHandler().authenticate("username", "newpassword"));

        // Delete the user
        userDao.delete("username", "me");

        TransactionUtil.commit();

        // Attempt to find the deleted user
        User deletedUser = userDao.getById(userId);
        Assert.assertNull(deletedUser);


//        DocumentDao documentDao = new DocumentDao();
//        Document document = getDocument();
//
//        // Create the document using DocumentDao
//        String documentId = documentDao.create(document, "test_user_id");
//
//
//        // Retrieve the created document
//        Document retrievedDocument = documentDao.getById(documentId);
//        Assert.assertNotNull(retrievedDocument);
//        Assert.assertEquals("Test Document", retrievedDocument.getTitle());
//        Assert.assertEquals("This is a test document.", retrievedDocument.getDescription());
//
//        // Update the document
//        retrievedDocument.setTitle("Updated Test Document");
//        documentDao.update(retrievedDocument, "test_user_id");
//
//
//        // Retrieve the updated document
//        Document updatedDocument = documentDao.getById(documentId);
//        Assert.assertNotNull(updatedDocument);
//        Assert.assertEquals("Updated Test Document", updatedDocument.getTitle());
//
//        // Delete the document
//        documentDao.delete(documentId, "test_user_id");
//
//
//        // Try to retrieve the deleted document
//        Document deletedDocument = documentDao.getById(documentId);
//        Assert.assertNull(deletedDocument);
//        TransactionUtil.commit();

    }


    @NotNull
    private static Document getDocument() {
        Document document = new Document();
        document.setTitle("Test Document");
        document.setDescription("This is a test document.");
        document.setSubject("Test Subject");
        document.setIdentifier("123456");
        document.setPublisher("Test Publisher");
        document.setFormat("PDF");
        document.setSource("Test Source");
        document.setType("Test Type");
        document.setCoverage("Test Coverage");
        document.setRights("Test Rights");
        document.setLanguage("English");
        document.setFileId("test_file_id");
        return document;
    }
}
//package com.sismics.docs.core.dao.jpa;
//
//import com.sismics.docs.BaseTransactionalTest;
//import com.sismics.docs.core.dao.UserDao;
//import com.sismics.docs.core.model.jpa.User;
//import com.sismics.docs.core.util.TransactionUtil;
//import com.sismics.docs.core.util.authentication.InternalAuthenticationHandler;
//import org.junit.Assert;
//import org.junit.Test;
//
///**
// * Tests the persistence layer.
// *
// * @author jtremeaux
// */
//public class TestJpa extends BaseTransactionalTest {
//    @Test
//    public void testJpa() throws Exception {
//        // Create a user
//        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUsername("username");
//        user.setPassword("12345678");
//        user.setEmail("toto@docs.com");
//        user.setRoleId("admin");
//        user.setStorageQuota(10L);
//        String id = userDao.create(user, "me");
//
//        TransactionUtil.commit();
//
//        // Search a user by his ID
//        user = userDao.getById(id);
//        Assert.assertNotNull(user);
//        Assert.assertEquals("toto@docs.com", user.getEmail());
//
//        // Authenticate using the database
//        Assert.assertNotNull(new InternalAuthenticationHandler().authenticate("username", "12345678"));
//
//        // Additional test: Update password and authenticate
//        String newPassword = "newPassword123";
//        user.setPassword(newPassword);
//        userDao.updatePassword(user, "me");
//
//        TransactionUtil.commit();
//
//        // Authenticate using the updated password
//        Assert.assertNotNull(new InternalAuthenticationHandler().authenticate("username", newPassword));
//    }
//}

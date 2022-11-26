package Main.Course;

import Main.People.Student;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseLibrary {

    private final Directory memoryIndex;
    private final StandardAnalyzer analyzer;
    private final IndexWriter writer;

    private final HashMap<String, Course> courseHashMap;

    private static CourseLibrary COURSE_LIBRARY;

    private CourseLibrary() {
        this.memoryIndex = new RAMDirectory();
        this.analyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig();
        try {
            this.writer = new IndexWriter(memoryIndex, indexWriterConfig);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        courseHashMap = new HashMap<>();

    }

    public static CourseLibrary getCourseLibrary(){
        if (COURSE_LIBRARY == null) COURSE_LIBRARY = new CourseLibrary();

        return COURSE_LIBRARY;
    }


    public void addClass(Course course) {
        Document doc = new Document();

        doc.add(new TextField("name", course.getName(), Field.Store.YES));
        doc.add(new TextField("description", course.getDescription(), Field.Store.YES));
        doc.add(new TextField("id", course.getId(), Field.Store.YES));

        try {
            this.writer.addDocument(doc);
            this.writer.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        courseHashMap.put(course.getId(), course);
    }

    public List<Course> search(String str) {

        List<Course> documents = null;
        MultiFieldQueryParser queryParser = new MultiFieldQueryParser(new String[]{"name", "description", "id"}, analyzer );

        try {
            IndexReader indexReader = DirectoryReader.open(memoryIndex);
            IndexSearcher searcher = new IndexSearcher(indexReader);

            TopDocs topDocs = searcher.search((queryParser.parse(str)), 10);
            documents = new ArrayList<>();
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                documents.add(courseHashMap.get(searcher.doc(scoreDoc.doc).get("id")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return documents;
    }

    public void enrollStudent(Student student, Course course){
        course.addStudent(student);
    }

    public void dropStudent(Student student, Course course) {
        course.dropStudent(student);
    }

    public List<Course> getAllCourses(){
        return new ArrayList<>(courseHashMap.values());
    }
}

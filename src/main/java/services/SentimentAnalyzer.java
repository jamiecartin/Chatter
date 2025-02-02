import edu.stanford.nlp.pipeline.*;

public class SentimentAnalyzer {
    private StanfordCoreNLP pipeline;
    
    public SentimentAnalyzer() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }
    
    public String analyze(String text) {
        Annotation annotation = pipeline.process(text);
        return annotation.get(CoreAnnotations.SentencesAnnotation.class).stream()
            .map(sentence -> sentence.get(SentimentCoreAnnotations.SentimentClass.class))
            .findFirst()
            .orElse("neutral");
    }
}

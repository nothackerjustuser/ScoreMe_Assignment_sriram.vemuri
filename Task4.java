package assignment;

import java.lang.System.Logger;
import java.util.List;
import javax.swing.text.Document;
import org.slf4j.LoggerFactory;

public class Task4 {

	private static final Logger log = LoggerFactory.getLogger(DocumentValidator.class);

	public ValidationResult validate(Document doc) {
		try {
			if (doc == null) {
				// FIX: Using specific exception or logging rather than just generic Runtime
				return new ValidationResult(false, "Document is null");
			}
			String content = doc.extractContent();
			if (content == null || content.isEmpty()) {
				return new ValidationResult(false, "Empty content");
			}
			return runValidationRules(content);

		} catch (Exception e) {
			// FIX 1: Replaced printStackTrace with structured logging
			log.error("Unexpected error during document validation", e);
			// FIX 2: Return a failed ValidationResult instead of null to prevent downstream
			// NPEs
			return new ValidationResult(false, "Internal Error");
		}
	}

	public void validateBatch(List<Document> docs) {
		for (Document doc : docs) {
			try {
				ValidationResult r = validate(doc);
				// FIX 3: Added null check on 'r' to prevent NPE if validate() returns null
				// (Defensive)
				if (r != null && r.isValid()) {
					saveResult(r);
				}
			} catch (Exception e) {
				// FIX 4: Log the exception so batch failures are traceable in production
				log.warn("Failed to process document in batch", e);
			}
		}
	}
}

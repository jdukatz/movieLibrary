package interact.movieIndex.api;

public class Movie {
	/*
	Basic class for a movie entry in the database.
	Setters pre-process string fields by replacing
	spaces with hyphens so they're easier to search
	on.
	*/

	private String title;
	private int year;
	private String producer;

	public String getTitle() {
		return this.title;
	}

	public int getYear() {
		return this.year;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setTitle(String title) {
		title = title.replaceAll("\\s", "-");
		this.title = title;
	}

	public void setYear(int year) {

		if (year > 1900) {
			this.year = year;
		} else {
			this.year = 0;
		}
	}

	public void setProducer(String producer) {
		producer = producer.replaceAll("\\s", "-");
		this.producer = producer;
	}
}
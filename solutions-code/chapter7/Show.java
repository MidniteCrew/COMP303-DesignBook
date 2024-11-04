//Problem 1: 
public class SponsoredConcert extends Concert{
	//Fields
	private String aSponsorName;
	private int aSponsorTime;

	//Constructor
	public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsorName, int, pSponsorTime){
		super(pTitle, pPerformer, pTime);
		this.aSponsorName = pSponsorName;
		this.aSponsorTime = pSponsorTime; 
	}

	// Define description() method. include title and performer + sponsor name
	@Override
	public String description(){
		return String.format("%s by %s and sponsored by: %s",title(), this.aPerformer, this.aSponsorName);
	}

	// Define time() method.
	@Override
	public int time(){
		return super.time() + this.aSponsorTime;
	}
}

//Problem 2:
// We can create a getter method that is either public or protected. 


//Problem 3:
	// 1. Abstract Class
	public abstract class AbstractShow implements Show{
		// Common fields
		private String aTitle;
		private int aTime;
	
		// Constructor
		protected AbstractShow(String pTitle, int pTime){
			this.aTitle = pTitle;
			this.aTime = pTime;
		}
	
		@Override
		public String title(){
			return aTitle;
		}
	
		public void setTitle(String pTitle){
			super.aTitle = pTitle;
		}
		
		public void setTime(int pTime){
			super.aTime = pTime;
		}
	
		@Override
		public int time(){
			return aTime;
		}
	}
	
	// 2. Concert Class
	public class Concert extends AbstractShow{
		//Fields
		private String aPerformer;

		//Constructor
		public Concert(String pTitle, int pTime, String pPerformer){
			super(pTitle, pTime);
			this.aPerformer = pPerformer;
		}

		@Override 
		public String description(){
			return String.format("%s by %s", super.title(), this.aPerformer);
		}
	}

	// 3. Movie class
	public class Movie extends AbstractShow{
		//Field
		private int aYear;

		//Constructor
		public Movie(String pTitle, int pTime, int pYear){
			super(pTitle, pTime);
			this.aYear = pYear;
		}

		@Override
		public String description(){
			return String.format("%s (%d)", aTitle, aYear);
		}
	}

//Problem 5:
public abstract class TemplateShow implements Show{

	@Override
	public final String description(){
		return ("%s: [...] ($d minutes)", aTitle, aTime, extra());
	}

	public abstract String extra();
}

//Problem 7: 
public abstract class AbstractShow{

	@Overload
	public void setTitle(String pTitle){
		//???
		aTitle = pTitle; 
	}

	public void setTime(int pTime){
		assert pTime > 0;
		aTime = pTime;
	}
}

//Class movie does not respect LSP since it has a stricter precondition than its superclass.


//Problem 8: 
// Both cases are overloading since we are defining methods of the same name but with different input arguments. 
// If we define it in AbstractShow we can call it on any time of AbstractShow whereas if we define it in movie 
// we can only call it on variables of type Movie (or subtypes).




//Problem 9:
	public abstract class AbstractShow{
		private Show aRecommended; 
	
		public void setRecommended(Show pShow){
			this.aRecommended = pShow;
		}
	
		public Show getRecommended(){
			return aRecommended;
		}
	}

	public class Movie extends AbstractShow{
		public void setRecommended(Movie pMovie){
			super.aRecommended = pMovie; 
		}

		public Movie getRecommended(){
			return (Movie) aRecommended;
		}
	}
	// It does respect LSP since the subtype "Movie" returns a type that is more specific than AbstractShow and
	// the preconditons & postconditions are the same.

//Problem 10:
public interace Show extends Cloneable{
	Show clone();
}

public AbstractShow clone(){
	try{
		return (AbstractShow) super.clone();
	}except(CloneNotSupportedException e){
		return null;
	}
}







	









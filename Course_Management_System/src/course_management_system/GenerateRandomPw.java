package course_management_system;


public class GenerateRandomPw {
	private int length;
	private String randomPassword;
//	this class can be used to assign random 8 digits password to the newly registered student or instructor
	public String generatePw() {
//		generating random password of 8 characters
		length = 8;
		randomPassword = "";
		for(int j = 0; j < length; j++) {
			
//			Adding random character to our password
			randomPassword += randomCharacter();
		}
		return randomPassword;
		
	}
	
	
	
	public static char randomCharacter() {
//		multiply by 62, cause there are 62 a-z characters(uppercase and lowercase) and numbers
		int rand = (int)(Math.random()*62);
		
		
		if(rand <= 9) {
//			Number (48-57 in ASCII)
//			adding Limit is 48 for the number
			int number = rand + 48;
			
			return (char)(number);
		} 
		else if(rand <= 35) {
//			Uppercase letter (65-90 in ASCII)
//			adding Limit is 55 for the uppercase
			int uppercase = rand + 55;

			return (char)(uppercase);
		} 
		else {
//			Lowercase letter (97-122 in ASCII)
//			adding Limit is 61 for the uppercase
			int lowercase = rand + 61;

			return (char)(lowercase);
		}
	}

}

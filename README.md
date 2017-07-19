# javaPractice
Practice Problem Solution
Demonstrate Use of Files, Strings and Simple Patterns In Java
 
Hypothetical Technical Requirement:

  Create a class that is able to read lines of text  from a file and parse each line into a list of tokens using tab as the token delimiter.  For example, given the following file contents:

	This<tab>is<tab>a<tab>test
	red<tab>green<tab>blue

  The implementation would first return the list [“This”, “is”, “a” and “test”] and then the list [“red”, “green” and “blue”].  

  Since we anticipate eventually parsing other types of files (ex: Comma separated, fixed length fields, etc.), the solution should be extensible to allow for that growth.  For this project, you should assume that your solution will be one component of a larger system and should take into consideration organization and documentation for other developers on the team, as well as technical factors such as varying input data and scalability.  This is an opportunity to demonstrate your API design and development skills.

  The token separator should be based on the extension of the filename submitted.  In this case, files of type “*.tab” should be parsed using tab as a separator.

  Feel free to ask clarifying questions or document assumptions made while designing your solution.

  In addition to the Java implementation, please provide unit tests covering success and error cases using the testing framework of your choice.

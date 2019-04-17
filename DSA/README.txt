--------------------------------------
Data Structures and Algorithms: README
--------------------------------------

Application: Word-Cloud Generator
Author: Conor Shortt - G00360253

PROJECT OUTLINE:
--------------------------------------------------------------------------------------------------
Write a program which can take in data from text files or websites, and generate a
word cloud with this data. Word-clouds are a mechanism for creating a visual representation
of text and are used to display a visual summary of the most prominent words used on a web page,
a news forum or a social media web site.
--------------------------------------------------------------------------------------------------

MAIN FEATURES:
--------------------------------------------------------------------------------------------------
-	Runner class: allows the program to run.
-	Menu class: allows the user choices 1, 2, 3 or -1. To input variables such as file name, 
	max words, and image name. And -1 to exit the menu.
-	Parser classes: user chooses to parse either a file or URL using 'U' or 'F'.
	The user can then parse data from the file/url the user entered and puts data into lists.
	Creates information from said data by comparing data off ignore words list. This allows
	for a better representation of the data, as the list isn't filled with conjunction words.
-	Frequency table: utilizes HashMap, LinkedList, LinkedHashSet. This class was programmed
	to put the words into a HashMap and count iterations of each word. This HashMap is then
	sorted with a sorting algorithm and put into a LinkedHashSet to remove duplicates.
	The list is now comprised of only the values from the HashMap, which are passed to to the
	word-cloud generator class.
-	Word-Cloud Generator: Takes in the values list as a parameter. The keys for each value
	are retrieved from the frequency table class which has a GetKey method. The keys and 
	values are then used to determine the font size, and the x and y position for each word.
--------------------------------------------------------------------------------------------------

EXTRAS:
--------------------------------------------------------------------------------------------------
- 	In word cloud gen class, the x and y incrementation is done through a small formula:
	for Y incrementation it takes the (fontSize * 0.9), I obtained this formula through
	trial and error, basically for enough room for the next line under roughly 90% of the fontSize
	is needed for the Y coordinate.
	For the X incrementation the formula I arrived at was (fontSize * 0.75) * string.length()
	Again through trial and error I arrived at this formula, it takes 75% of the font size and
	subsequently multiplies that by the amount of letters contained in the word, this gives the
	space needed.
-	For the image, I desired to have an ascending order for the words. I obtained this
	in the frequency table class, by utilizing a method I found on StackOverflow at 
	https://stackoverflow.com/questions/8119366/sorting-hashmap-by-values
	I tweaked this to suit my needs of course. The words get sorted in order and then
	duplicates are removed using a LinkedHashSet.
--------------------------------------------------------------------------------------------------
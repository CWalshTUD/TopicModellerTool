# TopicModellerTool
A simple topic modeller tool made in Java as part of TU857/2 OOP assignment

Classes
----------------
Control

Class that was originally inteded of handelling all the objects however as of now it's current purpose is to create the GUI object.

FileProcessor

The main workhorse of the project handelling file -> list conversion,sorting data and finally analysing the data presented by the text documents.

MainGUI

The simplistic GUI that allows users to select their text documents from within their own filesystem.


Core Functionality
------------------
The core feature of this project was to read 2 text files and calculate how similar each text document was towards eachother based on their most frequent words. Words that served no information (ie Stopwords e.g and,except,everyone etc) were filtered from these calculations. This was achieved by scanning each file into an ArrayList which was checked for any duplicate words or stop words. These Lists each had a Histogram list to log the amount of times each word was present in the document. Once these lists were fully populated they were sorted in descending order to find the Top 10 most occuring topics of each document.

Additional Features
--------------------
To improve upon this project a Simple GUI was created to help aid the user in selecting their files to compare. This GUI would provide visual feedback to the user in form of green checks or red crosses.
Another feature included was the ability for the user to choose their files for comparison through the Java System Explorer which had been filtered by default to only see documents in the .txt format.

For the future
---------------
I think it would be nice to be able to implement a file preview panel in the user's gui. I had originally intended on implementing this feature but lacked the knowledge and experience to be able to implement this in an efficent and time-friendly manner.

I feel many parts of this project could have been simplified into multiple methods rather than just the one huge method (e.g sortData() or scanTexts()). The lack of this I credit with my inexperience in java projects of this magnitude. As a result of my inexperience i feel this project dosen't embody the spirit of Object Orientated Programming as much as it could have been.

Finally i feel if i had better time management a 'Results output -> New file' feature could have been implemented.

# Street Traffic Data Analyzer

## Description
My project contains 4 java classes: 
- Main: handles the menu system and method calls 
- FileLoader: loads either the csv or json depending on user choice
- DataAnalyzer: has all the methods for the variaous calculations and summaries
- Street: used to create street objects

The user is prompted at the beginning to choose which file to load. 
Then the user is prompted with a new menu that allows them to select which 
operation they'd like to do. Both menus will loop until valid input is given, 
but the data analysis menu will loop until the user ends the session. When 
the session is ended, a final summary is given. 

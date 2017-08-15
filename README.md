# UnrealOutputLogReader
A java program to find your output messages in the log file for an Unreal Engine 4 game

This java program takes the log file produced by running an Unreal Engine game and 
sorts out the output that are relevant to you. 

## How to use it: 

1. In your Unreal game, print output messages to the log using the "Print String" 
	function in Blueprints. Run your game. 
2. Open the java file and type in the path to the log file for your game where 
	indicated. You can also change the output file path if you desire. 
3. Compile and run UnrealOutputLogReader.java
4. Open the output file, and voila! You have your relevant information. 

## Variations: 

You may need to change the number in line 57 (*builder.append(line.substring(76));*)
from 76 to another value depending on the length of the name of the class from which
you are printing output. If the output lines are truncated at the beginning, 
decrease the value by the number of characters that are missing. If there are extra
characters at the beginning, increase the value by the number of characters that 
are added. 

If you would only like to collect ouput from a particular Blueprint class, you can 
append the name of that class to the end of the string argument in line 44
(i.e. change *if (category.equals("LogBlueprintUserMessages: [")) {* to 
*if (category.equals("LogBlueprintUserMessages: ["YOUR_CLASS_NAME)) {*). Then in 
lines 39 and 43 you should increase the number "57" by the number of characters in 
*"YOUR_CLASS_NAME*. 

Hopefully this is helpful! 

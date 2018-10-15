# MusicTron3000
A convolutional neural network (CNN) made for analyzing emotion in music.

## Overview
A project made for Honors Humanities' Google 20 Project. Primarily uses Python and a TensorFlow implementation of Keras for the machine-learning model, as well as shell for *.mid* to *.csv* conversion and Java for *.csv* to *.png* conversion.

## Running the Model
In order to run the model for yourself, first run shell (Command Prompt) using [MIDICSV](http://www.fourmilab.ch/webtools/midicsv/) to convert *.mid* files (music) to *.csv* files (text files). If you only have access to *.mp3*, then you must first run a *.mp3* to *.mid* converter, which can be found anywhere online. After this is done, data can be imported into Python and fed through the model to generate the emotion your song conveys.

##### MIDICSV
After downloading MIDICSV, drag the application called *Midicsv* into your desktop, but do not launch it. Next, open up Command Prompt and switch your directory to the Desktop by running the following code:
> cd C:\Users\[username]\Desktop
Next, simply run the following command:


##### CSVtoImage
In order to run the *.java* file, you will need Eclipse or some other Java IDE to modify and run Java code. The java code can be found in the **CSVtoImage** folder. At the top of the file, simply change the *FILE_NAME* to the directory and file name of your *.csv* file. Then you should run the code and recieve a *.png* file, with each pixel and color channel representing a note in the music file.

##### The Model
In order to run the model, you will need some sort of Python editor or Jupyter notebook. 

## Altering the Model
This code is open source and can be redistributed, reused, or altered in any form or fashion. The code for altering the model can be found in the **Model** folder. If you would like to retrain the model, ensure that you have the appropriate libraries installed on your computer and you have a decent GPU. Training the model is very resource intensive, as the image files are by default 128x500!
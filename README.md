# MusicTron3000
A convolutional neural network (CNN) made for analyzing emotion in music.

## Overview
A project made for Honors Humanities' Google 20 Project. Primarily uses Python and a TensorFlow implementation of Keras for machine-learning model, as well as shell for .mid to .csv conversion and Java for .csv to .png conversion.

## Running the Model
In order to run the model for yourself, first run shell (Command Prompt) using [MIDICSV](http://www.fourmilab.ch/webtools/midicsv/) to convert *.mid* files (music) to *.csv* files (text files). If you only have access to *.mp3*, then you must first run a *.mp3* to *.mid* converter, which can be found anywhere online. After this is done, data can be imported into Python and into a readable data format using [Pickle](https://docs.python.org/3/library/pickle.html). Finally, the image can be fed through the model to generate the emotion your song conveys.

##### MIDICSV


##### CSVtoImage


##### Pickle


##### The Model


## Altering the Model
This code is open source and can be redistributed, reused, or altered in any form or fashion. The code for altering the model can be found in the **Model** folder.

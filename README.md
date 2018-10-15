# MusicTron3000
A convolutional neural network (CNN) made for analyzing emotion in music.

## Overview
A project made for Honors Humanities' Google 20 Project. Primarily uses Python and a TensorFlow implementation of Keras for the machine-learning model, as well as shell for *.mid* to *.csv* conversion and Java for *.csv* to *.png* conversion. The model currently uses 32 5x5 layers, 64 3x3 layers, and 64 3x3 layers before being densed into 64 values. These are then combined into 5 values, each scalars between 0.0 and 1.0 showing how much of the 5 emotions (Cheerful, Heroic, Suspense, Hopeful, Melancholy) a song conveys. Data Augmentation code and Image Pre-processing code was not included in this repository, as it is mainly designed for testing your own sample cases.

## Running the Model
In order to run the model for yourself, first run shell (Command Prompt) using [MIDICSV](http://www.fourmilab.ch/webtools/midicsv/) to convert *.mid* files (music) to *.csv* files (text files). If you only have access to *.mp3*, then you must first run a *.mp3* to *.mid* converter, which can be found anywhere online. After this is done, data can be imported into Python and fed through the model to generate the emotion your song conveys.

##### MIDICSV
After downloading MIDICSV, drag the application called *Midicsv* into your desktop, but do not launch it. Next, open up Command Prompt and switch your directory to the Desktop by running the following code:
```
cd C:\Users\<Username>\Desktop
```
Next, simply run the following command:
```
midicsv -v <InputFileName>.mid <OutputFileName>.txt
```
The new *.csv* file should be stored as a *.txt* and located in your desktop.

##### CSVtoImage
In order to run the *.java* file, you will need [Eclipse](https://www.eclipse.org/) or some other Java IDE to modify and run Java code. The java code can be found in the **CSVtoImage** folder. At the top of the file, simply change the *FILE_PATH* and *FILE_NAME* to the directory and file name of your *.csv* file. You may also resize the image to different lengths other than 500 by modifying the *MAX_LENGTH* value, but this **will require a retraining of the model.** Then you should run the code and recieve a *.png* file, with each pixel and color channel representing a note in the music file.

##### The Model
In order to run the model, you will need some sort of [Python](https://www.python.org/) editor or Jupyter notebook. For this project, Google Colab was used. Just simply change the *

## Altering the Model
This code is open source and can be redistributed, reused, or altered in any form or fashion. The code for altering the model can be found in the **Model** folder. If you would like to retrain the model, ensure that you have the appropriate libraries installed on your computer and you have a decent GPU. Training the model is very resource intensive, as the image files are by default 128x500!

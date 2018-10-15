import tensorflow as tf
from tensorflow.keras.datasets import cifar10
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Dropout, Activation, Flatten
from tensorflow.keras.layers import Conv2D, MaxPooling2D
from tensorflow.keras.callbacks import TensorBoard
from tensorflow.keras.optimizers import SGD, Adam

import pickle
import numpy as np

DATADIR = "/content/drive/My Drive/Google20/"

pickle_in = open(DATADIR + "datasetX.pickle","rb")
X = pickle.load(pickle_in)

pickle_in = open(DATADIR + "datasety.pickle","rb")
y = pickle.load(pickle_in)

y = np.array(y)

X = X/255.0
print(X.shape)
print(y.shape)
print(y[0])

model = Sequential()
model.add(Conv2D(48, (5, 5), input_shape=X.shape[1:]))
model.add(Activation('relu'))
# model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Conv2D(48, (5, 5)))
model.add(Activation('relu'))
# model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Conv2D(48, (5, 5)))
model.add(Activation('relu'))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Flatten()) 
model.add(Dense(64))
model.add(Activation('relu'))
model.add(Dense(5))
model.add(Activation('sigmoid'))

tensorboard = TensorBoard(log_dir= DATADIR + "logs/{}".format("Music Tron 3000"))

opt = Adam()
model.compile(loss='mean_squared_error',
              optimizer=opt,
              metrics=['accuracy'])

score = model.evaluate(X, y, batch_size=80, verbose=0)
print(score)
model.fit(X, y,
          batch_size=40,
          epochs=2,
          validation_split=0.2)
score = model.evaluate(X, y, batch_size=60, verbose=1)
print(score)

model.fit(X, y,
          batch_size=40,
          epochs=2,
          validation_split=0.2)
score = model.evaluate(X, y, batch_size=60, verbose=1)
print(score)

model.fit(X, y,
          batch_size=40,
          epochs=2,
          validation_split=0.2)
score = model.evaluate(X, y, batch_size=60, verbose=1)
print(score)

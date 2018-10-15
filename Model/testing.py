import cv2
import tensorflow as tf

CATEGORIES = ["Cheerful", "Heroic", "Suspense", "Hopeful", "Melancholy"]
FILE_NAMES = ["<Your Music>"]
FILE_PATH = "/content/drive/My Drive/Google20/"

def prepare(filepath):
    img_array = cv2.imread(filepath, cv2.IMREAD_GRAYSCALE)
    return img_array.reshape(-1, 128, 500, 1)

model = tf.keras.models.load_model(FILE_PATH + "MusicTron3000.model")

for name in FILE_NAMES:
    prediction = model.predict([prepare(FILE_PATH + name + ".png")])
    print(CATEGORIES)
    print(prediction)

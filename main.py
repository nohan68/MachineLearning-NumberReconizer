from sklearn.neural_network import MLPClassifier
import pickle
import sys

filename = 'finalized_model.sav'
xData = []
# file = open('debug.data', 'r')
# y = file.readline()
#
# for line in file:
#     ligne = line.replace("\n", "")
#     xData.append(int(ligne))

y = input()
print(y)
for line in sys.stdin.readlines():
    xData.append(int(line))

mlp = pickle.load(open(filename, 'rb'))
print("modele recharge")

resultat = mlp.predict([xData])
print("------")
print(resultat)
print(y)
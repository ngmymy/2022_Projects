#Project1 by My My Nguyen

import csv
from my_rng import *
global grammar

def new_grammar():
    """creates and returns a new grammar"""
    grammar = {}
    return grammar

def add_rule(grammar, left, right):
    """if there is a left component then append it if not then add on the right"""
    if left in grammar:
        if isinstance(right, str): #if right is a string
            grammar[left].append(right.split()) #add right to left as split strings
        else:
            input_list = []
            for item in right:
                input_list.append(item)
            grammar[left].append(input_list)
    else:
        if isinstance(right, str): #if right is a string
            grammar[left] = [right.split()]
        else:
            input_list = []
            for item in right:
                input_list.append(item)
            grammar[left] = [input_list]
        

def generate(grammar):
    """generates a random string using my_rng functions
    rules are reading in from csv
    if its a variable replace it with something if not var then move to finished list
    return list when there is nothing left"""
    sentence = []
    processing = ['Start'] #Default will always start with Start
    while processing:
        word = processing[0] 
        if word in grammar: #if start is in the dictionary then set random index, remove the index of one and then set new value keys
            index = next_int(0, len(grammar[word])-1)
            processing.pop(0)
            processing[0:0] = grammar[word][index] #dictionary of lists of lists of strings
        else:
            sentence.append(processing.pop(0))
    return sentence

def grammar_from_file(filename):
    """reads in file and creates and return a dictionary called grammar"""
    grammar = {}

    with open(filename, newline='') as csv_file:
        reader = csv.DictReader(csv_file)
        for row in reader:
            add_rule(grammar, row["variable"], row["replacement"])
    return grammar
    

def make_story(sentence):
    """function to help output everything on one line"""
    story = ""
    for words in sentence:
        story += words + " "
    print(story)

if __name__ == "__main__":
    import time
    set_seed(int(time.time()))
    file = input("Enter a filename: ")
    grammar = new_grammar()
    grammar = grammar_from_file(file)
    story = generate(grammar)
    make_story(story)
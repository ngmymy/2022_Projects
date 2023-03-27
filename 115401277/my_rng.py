global current_seed

def next():
    """updates current seed"""
    global current_seed
    current_seed = ((7**5)*current_seed)%((2**31)-1)
    return current_seed

def set_seed(new_seed):
    """sets the new current seed"""
    global current_seed
    current_seed = new_seed

def next_int(min, max):
    """adjusts current seed so that its in range"""
    next()
    range = max - min + 1
    return (current_seed % range) + min

def random_choice(seq):
    """generates a random sequence of numbers"""
    return seq[next_int(0, len(seq)-1)]

def menu():
    """Prints the menu screen"""
    print("RNG Utility\nA) Roll a dice\nB) pick a random option\nC) quit")

if __name__ == "__main__":
    import time
    set_seed(int(time.time()))
    while True:
        menu()
        user_input = input("Enter choice: ").strip().upper()
        if "A" <= user_input <= "C":
            if user_input == "A":
                try: #tries and catches any input that isn't an integer
                    min = int(input("Enter a minimum number: "))
                    max = int(input("Enter a maximum number: "))
                    while min > max:
                        max = int(input("Invalid number, enter a larger number "))
                    dice = int(input("Enter number of dice: "))
                except ValueError:
                    print("Inputs must be an integer")
                else: #if all inputs are integers then move on to else
                    total = 0
                    for i in range(dice):
                        random = next_int(min, max)
                        total += random
                        print("roll " + str(i + 1) + " = " + str(random))
                    print("sum = " + str(total))
            elif user_input == "B":
                word_lst = []
                #asks user for a word, if string is empty then print error
                word = input("Enter word options: ")
                word_lst.append(word)
                while word != "": #continue to ask for words until empty string is entered
                    word = input("Enter options or hit enter to pick a random option: ")
                    word_lst.append(word)
                if word_lst[0] == "":
                    print("error")
                else:
                    print(random_choice(word_lst))
            elif user_input == "C":
                print("Goodbye!")
                exit()
        else: #if user enters something other than A-C
            print("Invalid choice")
    
        
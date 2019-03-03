import itertools

def decrypt(message, key):
    return [i ^ j for i, j in zip(message, itertools.cycle(key))]

# mess1 = "Testing message.#@$%#%*&(*"
# key1 = "qwe"
# mess2 = [ord(n) for n in mess1]
# key2 = [ord(n) for n in key1]
# decrypted1 = decrypt(mess2, key2)
# print("".join([chr(x) for x in decrypted1]))
# encrypted1 = decrypt(decrypted1, key2)
# print("".join([chr(x) for x in encrypted1]))

with open("inputs/P_059.txt") as f:
    data = [int(n) for n in f.readline().split(",")]

chars = range(ord('a'), ord('z'))
perms = itertools.product(chars, repeat=3)

# n = 0
for key in perms:
    decrypted = "".join([chr(x) for x in decrypt(data, key)])
    # n += 1
    # if (n % 100 == 0):
    #     print(decrypted)
    if (decrypted.find(" the ") >= 0):
        print(decrypted)
        print("key:", "".join([chr(n) for n in key]))
        print("sum:", sum([ord(x) for x in decrypted]))

    
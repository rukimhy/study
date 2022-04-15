
li = ['Korea', 'America', 'China']
a = 0
str01 = ''

for i in li:
    for j in i:
        str01 += j[0]
        a = a+1
        if a>5:
            break

print('a :', a, ', str01 :', str01)
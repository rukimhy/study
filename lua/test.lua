--주석입니다.
--[[
--주석 여러줄 입니다.
--]]

function sayHello(i, j)
	print(i+j.." hello, world!")
end
sayHello(1, 2)

num = 1
if num == 1 then
	print("random="..math.random(1, 50))
	num = 2
end

if num == 1 then
	print("num="..num)
elseif num == 2 then
	print("num="..num)
end

a = {"A", "B", "C"}
print("length of a : "..#a)
for i = 1, #a do
	print("a["..i.."]="..a[i])
end

a.a1 = "900 Tiger"
a.a2 = 88
print("a[\"a1\"]="..a["a1"])
print("a[\"a2\"]="..a["a2"])

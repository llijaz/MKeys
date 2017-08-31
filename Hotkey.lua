args = {...}

keys = {}

local path = tostring(args[1])
local inpstr = tostring(args[2])

function getKeysstring()
	return tostring(args[3])
end

function getKey(i)
	if (string.sub(getKeysstring(), i + 1, i + 1) == "1") then
		return true
	else
		return false
	end
end

MOUSE1 = 16
MOUSE2 = 8
MOUSE3 = 4
SPACE = 32
RETURN = 10
SHIFT = 16
CONTROL = 17
ALT = 18
_0 = 48
_1 = 49
_2 = 50
_3 = 51
_4 = 52
_5 = 53
_6 = 54
_7 = 55
_8 = 56
_9 = 57
A = 65
B = 66
C = 67
D = 68
E = 69
F = 70
G = 71
H = 72
I = 73
J = 74
K = 75
L = 76
M = 77
N = 78
O = 79
P = 80
Q = 81
R = 82
S = 83
T = 84
U = 85
V = 86
W = 87
X = 88
Y = 89
Z = 90
F1 = 112
F2 = 113
F3 = 114
F4 = 115
F5 = 116
F6 = 117
F7 = 118
F8 = 119
F9 = 120
F10 = 121
F11 = 122
F12 = 123

local clock = os.clock
function sleep(n)
	n = n / 1000
    local t0 = clock()
    while clock() - t0 <= n do end
end

function stringlistener(string)
	
end

function keychanged()

end

function LeftClick()
	print "LeftClick"
end

function RightClick()
	print "RightClick"
end

function Click(a, b, c)
	if b == nil then
		print ("Click " .. tostring(a))
	elseif c == nil then
		print ("Click " .. tostring(a) .. " " .. tostring(b))
	else
		print ("Click " .. tostring(a) .. " " .. tostring(b) .. " " .. tostring(c))
	end
end

function WaitDef()
	-- sleep(0.01)
	print ("Wait")
end

function Wait(t)
	if t ~= nil then
		-- sleep(t)
		print ("Wait " .. t)
	else
		WaitDef()
	end
end

function WaitLong()
	-- sleep(0.1)
	print ("Wait Long")
end

function Debug()
	print "Debug"
end

function KeyType(k)
	if k ~= nil then
		print("KeyType " .. tostring(k))
	end
end

function KeyPress(k)
	if k ~= nil then
		print("KeyPress " .. tostring(k))
	end
end

function KeyRelease(k)
	if k ~= nil then
		print("KeyRelease " .. tostring(k))
	end
end

function Focus()
	print "Focus"
end

function Write(str)
	print("Write \"" .. str .. "\"")
end

function DisableThreading()
	print "DisableThreading"
end

function EnableThreading()
	print "EnableThreading"
end

function Clear()
	print "Clear"
end

function ClearKey(i)
	print("Clear " .. tostring(i))
end

function Print(s)
	print("Debug " .. tostring(s))
end

function onlyOnce()
	return true
end

function autoThread()
	return true
end

if path ~= "" and path ~= nil then
	dofile(path)
	
	if autoThread() then
		DisableThreading()
	end
	
	if inpstr ~= "" and inpstr ~= nil then
		stringlistener(inpstr)
	else
		keychanged()
	end
	
	if onlyOnce() then
		Clear()
	end
end

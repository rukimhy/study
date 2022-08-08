@echo off
chcp 65001
IF not exist "list.txt" (
	dir /s /b *.mkv > list.txt
)
mpv --playlist="list.txt"

import os

for dirpath, dirnames, filenames in os.walk('.'):
    for file in filenames:
        classFile = file.endswith(".class")
        if classFile:
            # print(f"{dirpath}: {file}")
            fullPath = os.path.join(dirpath,file)
            os.remove(fullPath)
            print(f"Removed File {file}")
        
import os
import json
import re

# Paths
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
JSON_PATH = os.path.join(BASE_DIR, "program.json")

# Read JSON data
with open(JSON_PATH, "r", encoding="utf-8") as f:
    programmes = json.load(f)

def sanitize_filename(name):
    # Convert to lowercase, replace spaces with underscores,
    # remove non-alphanumeric/underscore chars to be filename safe
    name = name.strip().lower()
    name = re.sub(r'\s+', '_', name)
    name = re.sub(r'[^a-z0-9_]', '', name)
    return name

def make_c_filename(num, short_name):
    num_str = f"{num:02d}"
    safe_name = sanitize_filename(short_name)
    return f"{num_str}_{safe_name}.c"

def create_c_file(filepath, full_desc, tags):
    # Create .c file content
    content = f"""// {full_desc}
// tags: {', '.join(tags)}

#include <stdio.h>

void main() {{

}}
"""
    with open(filepath, "w", encoding="utf-8") as f:
        f.write(content)

def main():
    # Create C files in the same BASE_DIR folder
    for item in programmes:
        num = item.get("No")
        short_name = item.get("Short Name", "program")
        full_desc = item.get("Full Description", "").replace('\n', ' ').strip()
        tags = item.get("Tags", [])
        
        filename = make_c_filename(num, short_name)
        full_path = os.path.join(BASE_DIR, filename)
        
        create_c_file(full_path, full_desc, tags)
        print(f"Created {filename}")

if __name__ == "__main__":
    main()

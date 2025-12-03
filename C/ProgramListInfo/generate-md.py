import os

LAST_PROGRAM = 39
DIR = ".."

# Output markdown file name
OUTPUT_MD = f"C_Programs_01_to_{LAST_PROGRAM}.md"


def sanitize_code(code):
    # Remove any trailing spaces from lines and keep formatting
    return "\n".join(line.rstrip() for line in code.splitlines())


def parse_c_file(filepath):
    with open(filepath, "r", encoding="utf-8") as f:
        lines = f.readlines()

    title = ""
    tags = []
    code_start_index = 0

    # Parse comments for title and tags
    for idx, line in enumerate(lines):
        if line.strip().startswith("//"):
            content = line.strip()[2:].strip()
            if content.startswith("tags:"):
                tags_line = content[5:].strip().strip(",")
                tags = [t.strip() for t in tags_line.split(",")]
            elif content:
                title = content
        else:
            # First non-comment line is code start
            code_start_index = idx
            break

    code = "".join(lines[code_start_index:])
    code = sanitize_code(code)
    return title, tags, code


def main():
    # Collect file info
    files = [f for f in os.listdir(DIR) if f.endswith(".c") and f[:2].isdigit()]
    files = [f for f in files if 1 <= int(f[:2]) <= LAST_PROGRAM]
    files.sort()

    with open(OUTPUT_MD, "w", encoding="utf-8") as md:
        for file in files:
            no = file[:2]
            title, tags, code = parse_c_file(os.path.join(DIR, file))
            if title == "":
                title = "No description"
            md.write(f"## {no}. {title}\n")
            if tags:
                tag_str = "`, `".join(tags)
                md.write(f"#### tags: `{tag_str}`\n\n")
            else:
                md.write("\n")
            md.write("```c")
            md.write(code)
            md.write("\n```\n\n")


if __name__ == "__main__":
    main()

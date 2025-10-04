# useful regex stuff

use \ for literals

## Digits:
\d+ → one or more digits
\d{n,m} → between n and m digits

Letters:
[a-zA-Z]+ → only alphabetic characters
\w+ → word characters (letters, digits, underscore)

Whitespace:
\s+ → one or more spaces, tabs, newlines
\S+ → non-whitespace sequences


Integer (with optional sign):
[-+]?\d+

Floating-point number (e.g. -12.34, 0.5, 3.):
[-+]?(?:\d*\.\d+|\d+\.\d*|\d+)

Hex number:
0[xX][0-9a-fA-F]+

Binary number:
0[bB][01]+

Valid identifier (like a variable name):
[a-zA-Z_]\w*

Email (simplified):
\w+@\w+\.\w+

URL (very simplified):
https?://\S+


## Parsing/Tokenizing

Split by spaces (multiple allowed):
\s+

Extract quoted strings:
Pattern pattern = Pattern.compile("\"([^\"]*)\"");  → matches text inside " "

Pattern pattern2 = Pattern.compile("'([^']*)'"); → matches text inside ' '

Comma-separated values (ignoring spaces):
\s*,\s*

## Useful Anchors

Line boundaries:
^pattern → match at start of line
pattern$ → match at end of line

Word boundaries:
\bword\b → exact word match
\B → non-boundary (useful in some edge cases)
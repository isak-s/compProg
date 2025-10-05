#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 4
const char *goal = "123-";

typedef struct {
    char state[5]; // 4 tiles + '\0'
    int dist;
} Node;

int visited[24]; // 24 permutations max
char seen[24][5];
int seenCount = 0;

int is_seen(const char *s) {
    for (int i = 0; i < seenCount; i++) {
        if (strcmp(seen[i], s) == 0) return 1;
    }
    return 0;
}

void mark_seen(const char *s) {
    strcpy(seen[seenCount++], s);
}

int bfs(const char *start) {
    Node q[100];
    int front = 0, back = 0;
    strcpy(q[back].state, start);
    q[back++].dist = 0;
    mark_seen(start);

    int dirs[4] = { -2, 2, -1, 1 }; // moves in linearized 2x2 grid
    while (front < back) {
        Node cur = q[front++];
        if (strcmp(cur.state, goal) == 0) return cur.dist;

        // find blank
        int pos = strchr(cur.state, '-') - cur.state;
        int row = pos / 2, col = pos % 2;

        // explore moves
        int drow[4] = { -1, 1, 0, 0 };
        int dcol[4] = { 0, 0, -1, 1 };

        for (int m = 0; m < 4; m++) {
            int nr = row + drow[m], nc = col + dcol[m];
            if (nr < 0 || nr >= 2 || nc < 0 || nc >= 2) continue;

            int npos = nr*2 + nc;
            Node nxt = cur;
            nxt.state[pos] = cur.state[npos];
            nxt.state[npos] = '-';

            if (!is_seen(nxt.state)) {
                mark_seen(nxt.state);
                nxt.dist = cur.dist + 1;
                q[back++] = nxt;
            }
        }
    }
    return -1; // shouldn’t happen
}

int main() {
    char line1[4], line2[4], start[5];
    fgets(line1, sizeof(line1), stdin);
    fgets(line2, sizeof(line2), stdin);
    snprintf(start, sizeof(start), "%c%c%c%c", line1[0], line1[1], line2[0], line2[1]);

    printf("%d\n", bfs(start));
    return 0;
}

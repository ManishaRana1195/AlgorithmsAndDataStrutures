package algorithms.union_find;


import java.util.ArrayList;

public class SocialNetworkConnectivity {

  private int _numberOfMembers;
  private int[] _friends;
  private int[] _friendTreeSize;

  private int _numberOfDisconnectedFriends;

  private SocialNetworkConnectivity(int numberOfMembers) {
    _numberOfMembers = numberOfMembers;
    _friends = new int[_numberOfMembers];
    _friendTreeSize = new int[_numberOfMembers];
    _numberOfDisconnectedFriends = numberOfMembers;

    for (int i = 0; i < _numberOfMembers; i++) {
      _friends[i] = i;
      _friendTreeSize[i] = 1;
    }
  }

  private int root(int node) {
    while (node != _friends[node]) {
      _friends[node] = _friends[_friends[node]];
      node = _friends[node];
    }

    return node;
  }

  private void union(int friendA, int friendB) {
    int rootA = root(friendA);
    int rootB = root(friendB);

    int treeASize = _friendTreeSize[rootA];
    int treeBSize = _friendTreeSize[rootB];
    if (treeASize > treeBSize) {
      _friendTreeSize[rootA] += treeBSize;
      _friends[rootB] = rootA;
      _numberOfDisconnectedFriends -= 1;
    } else {
      _friendTreeSize[rootB] += treeASize;
      _friends[rootA] = rootB;
      _numberOfDisconnectedFriends -= 1;
    }
  }

  private boolean connected(int friendA, int friendB) {
    return root(friendA) == root(friendB);
  }

  private boolean isConnected() {
    return _numberOfDisconnectedFriends == 1;
  }

  public static void main(String[] args) {
    ArrayList<InputObject> memberTimestampPairs = new ArrayList<>();
    memberTimestampPairs.add(new InputObject(0, 5, 3));
    memberTimestampPairs.add(new InputObject(1, 2, 5));
    memberTimestampPairs.add(new InputObject(3, 4, 7));
    memberTimestampPairs.add(new InputObject(3, 7, 9));
    memberTimestampPairs.add(new InputObject(7, 1, 10));
    memberTimestampPairs.add(new InputObject(8, 9, 15));
    memberTimestampPairs.add(new InputObject(2, 9, 17));
    memberTimestampPairs.add(new InputObject(5, 6, 21));
    memberTimestampPairs.add(new InputObject(4, 6, 24));
    memberTimestampPairs.add(new InputObject(4, 1, 25));
    memberTimestampPairs.add(new InputObject(8, 2, 27));

    SocialNetworkConnectivity socialNetwork = new SocialNetworkConnectivity(10);
    /*Create union between friends and check whether */
    for (InputObject pair: memberTimestampPairs) {
      int friendA = pair.friendA;
      int friendB = pair.friendB;
      System.out.println("Friend " + friendA + " and Friend " + friendB + " connected at time " + pair.timestamp);
      if (!socialNetwork.connected(friendA, friendB)) {
        socialNetwork.union(friendA, friendB);
      }

      if (socialNetwork.isConnected()) {
        System.out.println("All the friends are connected now at timestamp " + pair.timestamp);
        break;
      }
    }
  }

}

class InputObject {
  public int timestamp;
  public int friendA;
  public int friendB;

  public InputObject(int friendA, int friendB, int timestamp) {
    this.timestamp = timestamp;
    this.friendA = friendA;
    this.friendB = friendB;
  }
}

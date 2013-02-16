import java.util.Scanner;

public class Packet implements IPacket
{
	private int messageID;
	private int packetID;
	private int packetCount; // number of packets in this message
	private String payload;
	
	// default constructor
	public Packet()
	{
		this.messageID = 1337;
		this.packetID = 1337;
		this.packetCount = 9001;
		this.payload = "payload";
	}

	@Override
	public int compareTo(Packet packet)
	{
		int value = 0;

		if (this.equals(packet))
		{
			value = 1;
		} 
		else
		{
			value = -1;
		}

		return value;
	}
	
	public boolean equals(Packet packet)
	{
		boolean isEqual = false;
		
		if (this.messageID == packet.getMessageID() && this.packetID == packet.getPacketID() && this.packetCount == packet.getPacketCount() && this.payload == packet.getPayload())
		{
			isEqual = true;
		}		
		
		return isEqual;
	}

	@Override
	public int getMessageID()
	{
		return this.messageID;
	}

	@Override
	public int getPacketID()
	{
		return this.packetID;
	}

	@Override
	public int getPacketCount()
	{
		return this.packetCount;
	}

	@Override
	public String getPayload()
	{
		return this.payload;
	}

	@Override
	public Packet readPacket(Scanner inFile)
	{
		
		while(inFile.hasNext())
		{
			this.messageID = inFile.nextInt();
			this.packetID = inFile.nextInt();
			this.packetCount = inFile.nextInt();
			this.payload = inFile.nextLine();
		}
			
		return this;
	}
	
	@Override
	public String toString()
	{
		String output = "";
		String s = " ";
		
		output += this.messageID + s;
		output += this.packetID + s;
		output += this.packetCount + s;
		output += this.payload;
		
		return output;
	}
}

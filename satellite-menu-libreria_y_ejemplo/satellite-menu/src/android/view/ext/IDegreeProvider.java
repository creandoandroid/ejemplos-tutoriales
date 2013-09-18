package android.view.ext;

/**
 * Interface for providing degrees between satellites. 
 * 
 * @author creandoAndroid.com
 *
 */
public interface IDegreeProvider {
	public float[] getDegrees(int count, float totalDegrees);
}
